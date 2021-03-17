package com.thallium.sdvm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.thallium.sdvm.util.seasons.Season;
import com.thallium.sdvm.util.seasons.SeasonList;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.TimeCommand;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class SeasonCommands
{
    /*
        Originally from Fabric Seasons
    */
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("season").requires((source) -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("set")
                        .then(CommandManager.literal("spring")
                                .executes(context -> TimeCommand.executeSet(context.getSource(), 0))
                        )
                        .then(CommandManager.literal("summer")
                                .executes(context -> TimeCommand.executeSet(context.getSource(), 672000))
                        )
                        .then(CommandManager.literal("fall")
                                .executes(context -> TimeCommand.executeSet(context.getSource(), 672000*2))
                        )
                        .then(CommandManager.literal("winter")
                                .executes(context -> TimeCommand.executeSet(context.getSource(), 672000*3))
                        )
                )
                .then(CommandManager.literal("query")
                        .executes(context -> {
                            World world = context.getSource().getWorld();
                            SeasonList seasonList = Season.getCurrentSeason(world);
                            context.getSource().sendFeedback(new TranslatableText("tooltip.seasons.calendar_info_1").append(new TranslatableText("tooltip.seasons."+ seasonList.name().toLowerCase())), false);
                            context.getSource().sendFeedback(new LiteralText(Long.toString(((672000 - (world.getTimeOfDay() - ((world.getTimeOfDay()/672000)*672000) )) % 672000)/24000L)).append(new TranslatableText("tooltip.seasons.calendar_info_2").append(new TranslatableText("tooltip.seasons."+ seasonList.getNext().name().toLowerCase()))), false);
                            return 1;
                        })
                )
                .then(CommandManager.literal("skip")
                        .executes(context -> TimeCommand.executeAdd(context.getSource(), 672000))
                        .then(CommandManager.literal("spring")
                                .executes(context -> {
                                    World world = context.getSource().getWorld();
                                    SeasonList seasonList = Season.getCurrentSeason(world);
                                    int timeToNextSeason = Math.toIntExact((672000 - (world.getTimeOfDay() - ((world.getTimeOfDay()/672000)*672000) )) % 672000);
                                    switch (seasonList) {
                                        case SPRING:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*3));
                                        case SUMMER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*2));
                                        case FALL:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+672000);
                                        case WINTER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason);
                                    }
                                    return 0;
                                })
                        )
                        .then(CommandManager.literal("summer")
                                .executes(context -> {
                                    World world = context.getSource().getWorld();
                                    SeasonList seasonList = Season.getCurrentSeason(world);
                                    int timeToNextSeason = Math.toIntExact((672000 - (world.getTimeOfDay() - ((world.getTimeOfDay()/672000)*672000) )) % 672000);
                                    switch (seasonList) {
                                        case SPRING:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason);
                                        case SUMMER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*3));
                                        case FALL:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*2));
                                        case WINTER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+672000);
                                    }
                                    return 0;
                                })
                        )
                        .then(CommandManager.literal("fall")
                                .executes(context -> {
                                    World world = context.getSource().getWorld();
                                    SeasonList seasonList = Season.getCurrentSeason(world);
                                    int timeToNextSeason = Math.toIntExact((672000 - (world.getTimeOfDay() - ((world.getTimeOfDay()/672000)*672000) )) % 672000);
                                    switch (seasonList) {
                                        case SPRING:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+672000);
                                        case SUMMER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason);
                                        case FALL:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*3));
                                        case WINTER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*2));
                                    }
                                    return 0;
                                })
                        )
                        .then(CommandManager.literal("winter")
                                .executes(context -> {
                                    World world = context.getSource().getWorld();
                                    SeasonList seasonList = Season.getCurrentSeason(world);
                                    int timeToNextSeason = Math.toIntExact((672000 - (world.getTimeOfDay() - ((world.getTimeOfDay()/672000)*672000) )) % 672000);
                                    switch (seasonList) {
                                        case SPRING:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*2));
                                        case SUMMER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+672000);
                                        case FALL:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason);
                                        case WINTER:
                                            return TimeCommand.executeAdd(context.getSource(), timeToNextSeason+(672000*3));
                                    }
                                    return 0;
                                })
                        )
                )
        );
    }
}
