package org.example;

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;

import java.util.Properties;



public class Feedback_Analysis {
    public static String testAnalysis(String line )
    {
        Properties pipelineProps = new Properties();
        Properties tokenizerProps = new Properties();
        pipelineProps.setProperty("annotators", "parse, sentiment");
        pipelineProps.setProperty("parse.binaryTrees", "true");
        pipelineProps.setProperty("enforceRequirements", "false");
        tokenizerProps.setProperty("annotators", "tokenize, ssplit");
        StanfordCoreNLP tokenizer = new StanfordCoreNLP(tokenizerProps);
        StanfordCoreNLP pipeline = new StanfordCoreNLP(pipelineProps);


        Annotation annotation = tokenizer.process(line);
        pipeline.annotate(annotation);
        // normal output
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            String output = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            System.out.println(output + ": "  + sentence);
        }
        return line;
    }
}
