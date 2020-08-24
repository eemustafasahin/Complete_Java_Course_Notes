package org.csystem.app.samples.commandpromptapp;

public class CommandPromptApp {
    private CommandPromptApp()
    {
    }

    public static void run()
    {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();
    }
}
