package com.example.parser.parser;

import com.example.parser.lexer.LexerException;

public class ParserException extends LexerException {

  public ParserException(String detailMessage, int position) {
    super(detailMessage, position);
  }
}
