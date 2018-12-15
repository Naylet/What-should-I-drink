package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	public static Interface gui;
	
    public static final void main(String[] args) {
        try {

        	gui = new Interface();
        	
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static enum Answer {UNKNOWN,YES,NO};
    
    public static class Question {
    	
    	public String content;
        public Answer answer;
        
        public Question(String content) {
        	this.content = content;
        	this.answer = Answer.UNKNOWN;
        }
        
        public void ask() {
        	String returnAnswer = gui.showQuestion(this.content); 
        	//while(returnAnswer!="YES"||returnAnswer!="NO") {}
        	
        	if(returnAnswer == "YES") this.answer = Answer.YES;
        	else this.answer = Answer.NO;
        	
        	System.out.println("Given answer: " + this.answer);
        }
        
        public void setResult(String[] results) {
        	System.out.println("Result: ");
        	for(int i=0; i<results.length; i++) System.out.println(results[i]);

        	gui.showResult(results);
        }
        
    }

}
