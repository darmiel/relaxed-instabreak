![relaxed_instabreak](https://github.com/darmiel/relaxed-instabreak/assets/71837281/c711946c-50bc-4e20-b3fa-13c2851aaa15)

This mod **adds a short cooldown after breaking a block while holding down the mouse button** (toggleable: while or while not sneaking).

It should be pretty similar to the creative mode experience -> blocks can be mined immediately, but it only breaks around 3 blocks per second, while holding down the mouse button.

**This mod works on servers**, but only needs to be installed on the client.

## Available Versions

| Loader | Minecraft Version | Directory |
|--------|------------------|-----------|
| Fabric | 1.21.1 | [`fabric/`](fabric/) |
| Forge | 1.20.1 | [`forge-1.20.1/`](forge-1.20.1/) |
| NeoForge | 1.21.1 | [`neoforge-1.21.1/`](neoforge-1.21.1/) |

Each version is a self-contained Gradle project. Build them independently:

```bash
# Fabric (1.21.1)
cd fabric && ./gradlew build

# Forge (1.20.1)
cd forge-1.20.1 && ./gradlew build

# NeoForge (1.21.1)
cd neoforge-1.21.1 && ./gradlew build
```

## Config

- `Always Enabled`: If enabled, the block-breaking cooldown is always active.
- `Reversed Behavior`: By default, Relaxed Instabreak is activated as soon as you sneak. If this option is enabled, Relaxed Instabreak will be disabled when sneaking.
- `Delay`: Cooldown after the removal of blocks in ticks. Default: 5 Ticks.

The Fabric version uses Cloth Config for the config GUI (with Mod Menu integration).
The Forge and NeoForge versions use the native config system (configurable via the mod list screen).

## Preview

Note: a Netherite Pickaxe with Efficiency V and Haste II was used in the demo.

### Vanilla Behavior
![vanilla_behavior](https://github.com/darmiel/relaxed-instabreak/assets/71837281/397b00d6-9f54-4b16-8366-07cc1d058b12)

### Relaxed Instabreak Behavior
![relaxed_instabreak_behavior](https://github.com/darmiel/relaxed-instabreak/assets/71837281/ed8a0f73-fbaa-4297-9026-fc640c4127e3)

## License

CC0 1.0 Universal
