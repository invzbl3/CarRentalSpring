package com.project.carrental.service.factory;

import com.project.carrental.service.command.ICommand;
import com.project.carrental.service.command.NoCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class CommandFactory {
    private final Map<String, ICommand> commands;

    public ICommand getCommand(String request) {
        return commands.getOrDefault(request, new NoCommand());
    }
}
