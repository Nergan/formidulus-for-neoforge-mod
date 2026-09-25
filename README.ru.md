[English](README.md) | [Русский](README.ru.md)

# Formidulus

Босс и несколько легенд для Minecraft 1.21.1 на NeoForge. Это порт [Formidulus](https://github.com/absolutelyaya/Formidulus) от Absolutelyaya.

![логотип](ico.png)

## Загрузки

GitHub Release `v0.1.2`: [github.com/Nergan/formidulus-for-neoforge](https://github.com/Nergan/formidulus-for-neoforge/releases)

| Файл | Нужен | Примечание |
| --- | --- | --- |
| `formidulus-0.1.2.jar` | Да | Этот мод |
| `kotlinforforge-5.8.0-all.jar` | Да | [Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge) |
| `*-sources.jar` | Нет | В `mods` его класть не нужно |

Modrinth: [formidulus-for-neoforge](https://modrinth.com/project/formidulus-for-neoforge)

## Требования

- Minecraft 1.21.1
- NeoForge 21.1.209 или новее
- Java 21
- Kotlin for Forge 5.8 или новее

## Установка

Положи `formidulus-0.1.2.jar` и `kotlinforforge-5.8.0-all.jar` в папку `mods`.

## Конфиг

Серверный конфиг, общий для всех игроков. Файл: `saves/<мир>/serverconfig/formidulus-server.toml` (на выделенном сервере: `world/serverconfig/formidulus-server.toml`). Экран настроек открывается из списка модов NeoForge.

| Ключ | По умолчанию | Смысл |
| --- | --- | --- |
| `world.cultist_mending_chance` | `0.1` | Шанс, что культист лечится во время поклонения |
| `world.deer_warning` | `true` | Предупреждать игроков перед боем с богом-оленем |
| `world.fight_check_inverval` | `100` | Как часто спавнер босса проверяет бой, в тиках. В ключе сохранена опечатка оригинала |
| `world.jolly_chance` | `0.01` | Шанс, что моб станет праздничным |

## Лицензия

Gradle-проект, точка входа на Kotlin и обвязка NeoForge — MPL-2.0 (`LICENSE`). Игровой код взят из Formidulus и остаётся под MIT (`LICENSE-FORMIDULUS`, Copyright (c) 2024 Absolutelyaya).
