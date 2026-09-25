[English](README.md) | [Русский](README.ru.md)

# Formidulus

A boss and a few legends for Minecraft 1.21.1 on NeoForge. This is a port of [Formidulus](https://github.com/absolutelyaya/Formidulus) by Absolutelyaya.

![logo](ico.png)

## Downloads

GitHub Release `v0.1.2`: [github.com/Nergan/formidulus-for-neoforge](https://github.com/Nergan/formidulus-for-neoforge/releases)

| File | Required | Notes |
| --- | --- | --- |
| `formidulus-0.1.2.jar` | Yes | This mod |
| `kotlinforforge-5.8.0-all.jar` | Yes | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `*-sources.jar` | No | Do not put this in `mods` |

Modrinth: [formidulus-for-neoforge](https://modrinth.com/project/formidulus-for-neoforge)

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.209 or newer
- Java 21
- Kotlin for Forge 5.8 or newer

## Install

Put `formidulus-0.1.2.jar` and `kotlinforforge-5.8.0-all.jar` into the `mods` folder.

## Config

Server config, shared with every player. File: `saves/<world>/serverconfig/formidulus-server.toml` (on a dedicated server: `world/serverconfig/formidulus-server.toml`). The NeoForge config screen opens from the mods list.

| Key | Default | Meaning |
| --- | --- | --- |
| `world.cultist_mending_chance` | `0.1` | Chance a cultist mends while worshipping |
| `world.deer_warning` | `true` | Warn players before the deer god fight |
| `world.fight_check_inverval` | `100` | Boss-spawner check interval, in ticks. The key keeps the original spelling |
| `world.jolly_chance` | `0.01` | Chance a mob becomes jolly |

## License

The port's Gradle project, Kotlin entry, and NeoForge wiring are MPL-2.0 (`LICENSE`). The gameplay code comes from Formidulus and stays MIT (`LICENSE-FORMIDULUS`, Copyright (c) 2024 Absolutelyaya).
