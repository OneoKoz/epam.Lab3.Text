package com.epam.jwd.parser;

import com.epam.jwd.exception.InvalidOperatorException;
import com.epam.jwd.model.AbstractNotation;

public class ChainParser {
    public static final ChainParser instance = new ChainParser();

    private final Parser textParser = new TextParser();
    private final Parser paragraphParser = new ParagraphParser();
    private final Parser sentenceParser = new SentenceParser();
    private final Parser lexemeParser = new LexemeParser();

    ChainParser() {
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
    }

    public void parse(AbstractNotation abstractNotation, String... strings)throws InvalidOperatorException {
        textParser.parse(abstractNotation, strings);
    }
}
