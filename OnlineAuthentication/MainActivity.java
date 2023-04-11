package com.example.assignment9;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static int PICK_ACCOUNT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tokenText = findViewById(R.id.token);

        AccountManager accountManager = AccountManager.get(getApplicationContext());
        Intent googlePicker = AccountManager.newChooseAccountIntent(null, null, new String[] { "com.google"},
                true, null, null, null, null);
        startActivityForResult(googlePicker, PICK_ACCOUNT_REQUEST);
    }

    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_ACCOUNT_REQUEST && resultCode == RESULT_OK) {
            Bundle options = new Bundle();
            AccountManager accountManager = AccountManager.get(this);
            Account[] accounts = accountManager.getAccounts();
            for (Account a : accounts) {
                Log.d("onActivityResult", "type--- " + a.type + " ---- name---- " + a.name);
                accountManager.invalidateAuthToken(a.type, null);
                accountManager.getAuthToken(
                        a, // Account retrieved using getAccountsByType()
                        "Manage your tasks", // Auth scope
                        options, // Authenticator-specific options
                        this, // Your activity
                        new OnTokenAcquired(), // Callback called when a token is successfully acquired
                        new Handler(new OnError())); // Callback called if an error occurs
            }
        }
    }

    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
        TextView tokenText = findViewById(R.id.token);
        @Override
        public void run(AccountManagerFuture<Bundle> result) {
            try {
                Bundle bundle = result.getResult();
                String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                Log.d("OnTokenAcquired", "authToken: " + token);
                System.out.println(token);
                tokenText.setText("Token is: \n" + token.toString());
                // do something with authToken
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.e("OnTokenAcquired", "Exception: " + e.getMessage());
                //System.out.println("here 1");
                e.printStackTrace();
            }
        }
        public class networkThread implements Runnable {
            AccountManagerFuture<Bundle> result;

            public networkThread(AccountManagerFuture<Bundle> result) {
                this.result = result;
            }

            @Override
            public void run() {
                try {
                    Intent launch = (Intent) result.getResult().get(AccountManager.KEY_INTENT);
                    if (launch != null) {
                        startActivityForResult(launch, 0);
                        return;
                    }
                    Bundle bundle = null;
                    bundle = result.getResult();
                    // The token is a named value in the bundle. The name of the value
                    // is stored in the constant AccountManager.KEY_AUTHTOKEN.
                    String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                    System.out.println("Token Received: " + token);
                    tokenText.setText("Token is: \n" + token.toString());
                }
                catch (AuthenticatorException | OperationCanceledException | IOException e) {
                    Log.e("networkThread", "Exception: " + e.getMessage());
                    //System.out.println("here 2");
                    e.printStackTrace();
                }
            }
        }
    }
    private class OnError implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            // Implement your error handling code here
            Log.e("OnError", "An error occurred during the authentication process");
            System.out.println("OnError method returned an error");
            return true;
        }

    }

}
