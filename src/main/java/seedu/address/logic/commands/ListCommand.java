package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all clients.\n\n"
            + "Format: "
            + COMMAND_WORD + "\n\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Listed all clients";
    public static final String MESSAGE_EMPTY_LIST = "No clients found, start adding clients using the Add command!";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        if (model.getFilteredPersonList().isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        } else {
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }
}
