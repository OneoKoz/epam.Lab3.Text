package com.epam.jwd.parser;

import com.epam.jwd.exception.InvalidOperatorException;
import com.epam.jwd.model.AbstractNotation;
import com.epam.jwd.model.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class TextParser extends Parser{

    private static final String PARAGRAPH_REGEXP = "[ ]{4}(.+)";

    @Override
    public void parse(AbstractNotation text, String... allStr) throws InvalidOperatorException{
        super.parse(text, allStr);
        List<String> tempParseStr = new ArrayList<>();
        for (String str : allStr) {
            if (str.matches(PARAGRAPH_REGEXP)) {
                parseNext(text, tempParseStr);
                tempParseStr.clear();
            }
            tempParseStr.add(str);
        }
        parseNext(text, tempParseStr);

    }

    private void parseNext(AbstractNotation text, List<String> parseStr) throws InvalidOperatorException {
        if (!parseStr.isEmpty()) {
            Paragraph paragraph = new Paragraph();
            text.addNode(paragraph);
            String[] pStringsArr = new String[parseStr.size()];
            nextParser.parse(paragraph, parseStr.toArray(pStringsArr));
        }
    }
}
