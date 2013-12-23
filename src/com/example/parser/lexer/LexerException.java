package com.example.parser.lexer;

public class LexerException extends Exception {

  int position;

  public LexerException(String detailMessage, int position) {
    super(detailMessage);
    this.position = position;
  }

  public int getPosition() {
    return position;
  }
}
