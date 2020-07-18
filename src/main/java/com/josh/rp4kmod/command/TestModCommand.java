package com.josh.rp4kmod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class TestModCommand {

    public static void register (CommandDispatcher<CommandSource> dispatcher){

        // Command name
        dispatcher.register(Commands.literal("hello")
                .executes(source -> {
                    return test(source.getSource(), source.getSource().asPlayer());

                    // Command Arg  1
                }).then(Commands.argument("target", EntityArgument.player())
                        .executes(source -> {
                            return test(source.getSource(), EntityArgument.getPlayer(source, "target"));
                        })));
    }

    private static int test(CommandSource source, PlayerEntity player){

        // Print Hello Text
        source.sendFeedback(new TranslationTextComponent("commands.hello", player.getDisplayName()), true);
        return 1; // success
    }
}
