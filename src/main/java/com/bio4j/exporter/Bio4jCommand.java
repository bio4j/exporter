package com.bio4j.exporter;

import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.ComplexCommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;

import com.tinkerpop.gremlin.console.Mediator;

public class Bio4jCommand extends CommandSupport {
	  private final Mediator mediator;
	
	public Bio4jCommand(final Groovysh shell, final Mediator mediator) {
		super(shell, ":bio4j", ":b4j");
        this.mediator = mediator;
    }

	@Override
	public Object execute(List<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
