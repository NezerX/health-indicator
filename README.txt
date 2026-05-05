You can find the Latest version here: https://github.com/NezerX/health-indicator/releases

Health Indicator

Health Indicator is a lightweight Minecraft mod for the Forge loader that adds a clean, Souls-like health display for hostile mobs[cite: 1, 4].

Features

Souls-like Health Bar: A multi-layered indicator featuring a background, a primary health layer, and a "damage" layer that lingers and fades gradually after a hit[cite: 2].

Contextual Visibility: To maintain a clean UI, the bar only appears when a mob is aggressive, taking damage, or in a specific state like a Creeper about to explode[cite: 2].

Dynamic Damage Text: Shows the exact amount of damage dealt below the health bar. The text is rendered at full brightness for perfect visibility in dark environments[cite: 2].

Smart Targeting: Automatically filters out passive mobs. The health indicator is strictly for hostile enemies and entities in combat[cite: 2].

Distance & Line-of-Sight: Bars are automatically hidden if the mob is behind a wall or further than 20 blocks away from the player[cite: 2].

Mechanics

Automatic Caching: Uses a WeakHashMap to track mob health states, ensuring the mod uses minimal memory and automatically cleans up when mobs despawn[cite: 2].

Zero Configuration: Designed as a "plug and play" mod. No menus, no config files, and no complex setup required[cite: 1, 2].

Technical Information

Minecraft Version: 1.20.1[cite: 4]

Mod Loader: Forge[cite: 1, 4]

Mappings: Mojang[cite: 2, 3]

Environment: Client-side rendering[cite: 1, 2].

Installation

Ensure you have the latest version of the Forge Loader for 1.20.1 installed.

Download the Health Indicator jar file.

Place the jar file into your mods folder.

Building from source

To build the mod locally, clone the repository and run the following command in your terminal:

./gradlew build

The compiled jar will be located in build/libs.

Contributing

Contributions are welcome. Please follow these steps:

1. Fork the repository.
2. Create a feature branch.
3. Submit a Pull Request with a detailed description of your changes.

For bug reports, please use the GitHub Issues tab.

License

This project is licensed under the MIT License[cite: 4]. You are free to use the code with proper attribution.
