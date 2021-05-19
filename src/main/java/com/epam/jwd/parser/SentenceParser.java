package com.epam.jwd.parser;

import com.epam.jwd.exception.InvalidOperatorException;
import com.epam.jwd.model.AbstractNotation;
import com.epam.jwd.model.Lexeme;

public class SentenceParser extends Parser {

    private static final String LEXEME_SPLITTER = "(\\s+)";

    @Override
    public void parse(AbstractNotation sentence, String... strings)throws InvalidOperatorException {
        super.parse(sentence, strings);
        String[] lexemes = strings[0].split(LEXEME_SPLITTER);
        for (String lexemeStr : lexemes) {
            Lexeme lexeme = new Lexeme();
            sentence.addNode(lexeme);
            nextParser.parse(lexeme, lexemeStr);
        }

    }
}
