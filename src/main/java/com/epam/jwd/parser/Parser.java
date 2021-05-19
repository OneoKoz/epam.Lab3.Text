package com.epam.jwd.parser;

import com.epam.jwd.exception.InvalidOperatorException;
import com.epam.jwd.model.AbstractNotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Parser {

    private static final Logger LOGGER = LogManager.getLogger(Parser.class);

    protected Parser nextParser;

    public void parse(AbstractNotation abstractNotation, String... str) throws InvalidOperatorException {
        if (nextParser == null) {
            LOGGER.error("Has not next parser");
        }
    }

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }
}
