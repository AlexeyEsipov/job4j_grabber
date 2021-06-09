package ru.job4j.ood.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store supportItem, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, supportItem);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store support = new SupportItem()) {
            support.init();
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateNewItem(output));
            actions.add(new DeleteItem(output));
            actions.add(new PrintAllPoint(output));
            actions.add(new PrintMenuTitle(output));
            actions.add(new PrintOnePoint(output));
            actions.add(new PrintPriority(output));
            actions.add(new ReplaceDescription(output));
            actions.add(new ReplaceNumber(output));
            actions.add(new PerformAction(output));
            actions.add(new ExitProgram(output));
            new StartUI(output).init(input, support, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

