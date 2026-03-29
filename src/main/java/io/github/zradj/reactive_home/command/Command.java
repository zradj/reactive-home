package io.github.zradj.reactive_home.command;

public interface Command {

  void execute();

  void undo();
}
