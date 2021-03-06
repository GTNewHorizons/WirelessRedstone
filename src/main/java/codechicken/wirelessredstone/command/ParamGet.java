package codechicken.wirelessredstone.command;

import codechicken.lib.command.CoreCommand;
import codechicken.wirelessredstone.manager.RedstoneEther;
import net.minecraft.command.ICommandSender;

public class ParamGet extends FreqParam {

    @Override
    public void printHelp(ICommandSender listener) {
        CoreCommand.chatT(listener, "wrcbe.param.get.usage");
        CoreCommand.chatT(listener, "wrcbe.param.get.usage1");
        CoreCommand.chatT(listener, "wrcbe.param.get.usage2");
        CoreCommand.chatT(listener, "wrcbe.param.get.usage3");
    }

    @Override
    public String getName() {
        return "get";
    }

    @Override
    public void handleCommand(String playername, String[] subArray, ICommandSender listener) {
        RedstoneEther ether = RedstoneEther.get(false);

        if (subArray.length != 2) {
            CoreCommand.chatT(listener, "wrcbe.param.invalidno");
            return;
        }

        if (subArray[1].equals("public")) {
            CoreCommand.chatT(listener, "wrcbe.param.get.public", ether.getLastPublicFrequency());
        } else if (subArray[1].equals("shared")) {
            if (ether.getLastPublicFrequency() >= ether.getLastSharedFrequency()) {
                CoreCommand.chatT(listener, "wrcbe.param.get.shared0");
            } else {
                CoreCommand.chatT(listener, "wrcbe.param.get.shared", ether.getLastPublicFrequency() + 1, ether.getLastSharedFrequency());
            }
        } else if (subArray[1].equals("private")) {
            CoreCommand.chatT(listener, "wrcbe.param.get.private", ether.getNumPrivateFreqs());
        } else {
            CoreCommand.chatT(listener, "wrcbe.param.invalid");
        }
    }
}
