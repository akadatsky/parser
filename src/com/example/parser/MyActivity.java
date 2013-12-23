package com.example.parser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.parser.lexer.LexerException;
import com.example.parser.parser.Parser;

public class MyActivity extends Activity {

  public static final String input = "(( 2 + 3 )*4)";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Parser parser = new Parser(input);
    String result = null;
    try {
      result = parser.parse();
    } catch (LexerException e) {
      Log.e("Parser", "", e);
    } catch (Exception e){
      Log.e("Parser", "", e);
    }
    Toast.makeText(this, result, Toast.LENGTH_LONG).show();


  }

}
