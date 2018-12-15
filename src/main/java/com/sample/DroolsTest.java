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
        	if( gui.showQuestion(this.content) == "YES") this.answer = Answer.YES;
        	else this.answer = Answer.NO;
        }
        
    }

}
