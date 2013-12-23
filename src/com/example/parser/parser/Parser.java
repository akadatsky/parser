package com.example.parser.parser;

import com.example.parser.lexer.Lexeme;
import com.example.parser.lexer.Lexer;
import com.example.parser.lexer.LexerException;

public class Parser {

  private String input;
  private Lexer lexer;

  public Parser(String input) {
    this.input = input;
  }

  public String parse() throws LexerException {
    String result;

    lexer = new Lexer(input);
    lexer.parse();

    result = Double.toString(expression());

    return result;
  }

  private double expression() {
    double result = token();
    while (isSignPlusMinus()) {
      if (lexer.getCurrent().getType() == Lexeme.Type.PLUS) {
        lexer.moveToNext();
        result += token();
      }
      if (lexer.getCurrent().getType() == Lexeme.Type.MINUS) {
        lexer.moveToNext();
        result -= token();
      }
    }
    return result;
  }

  private boolean isSignPlusMinus() {
    if (lexer.getCurrent().getType() == Lexeme.Type.PLUS ||
        lexer.getCurrent().getType() == Lexeme.Type.MINUS) {
      return true;
    } else {
      return false;
    }
  }

  private double token() {
    double result = term();
    while (isSignMulDiv()) {
      if (lexer.getCurrent().getType() == Lexeme.Type.MUL) {
        lexer.moveToNext();
        result *= token();
      }
      if (lexer.getCurrent().getType() == Lexeme.Type.DIV) {
        lexer.moveToNext();
        result /= token();
      }
    }
    return result;
  }

  private boolean isSignMulDiv() {
    if (lexer.getCurrent().getType() == Lexeme.Type.MUL ||
        lexer.getCurrent().getType() == Lexeme.Type.DIV) {
      return true;
    } else {
      return false;
    }
  }

  private double term() {
    double result;
    if (lexer.getCurrent().getType() == Lexeme.Type.NUMBER) {
      result = Double.parseDouble(lexer.getCurrent().getValue());
      lexer.moveToNext();
    } else {
      if (lexer.getCurrent().getType() == Lexeme.Type.LEFT_BKT) {
        lexer.moveToNext();
      }
      result = expression();
      if (lexer.getCurrent().getType() == Lexeme.Type.RIGHT_BKT) {
        lexer.moveToNext();
      }
    }
    return result;
  }
}
