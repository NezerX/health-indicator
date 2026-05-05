Health IndicatorHigh-performance health visualization mod for Minecraft 1.20.1 (Forge). This mod provides a streamlined, combat-oriented interface by displaying health bars only when necessary.  Key FeaturesFeatureDescriptionSouls-like AnimationImplements a dual-layer health bar. When damage is taken, a secondary "damage" layer lingers before smoothly catching up to the current health.  Contextual LogicThe indicator is hidden by default. It appears only during active combat, when a mob is hurt, or when a Creeper begins its explosion sequence.  Smart FilteringAutomatically distinguishes between hostile and passive entities. Only mobs belonging to the Enemy class or showing direct aggression trigger the UI.  Optimized RenderingBars are hidden behind solid blocks (line-of-sight check) and are culled beyond a 20-block radius to prevent screen clutter.  Low-Light VisibilityDamage numbers are rendered using full-bright light textures, ensuring readability in total darkness.  Technical SpecificationsPlatform: Minecraft Forge 1.20.1.  Mappings: Mojang Mappings.  Data Management: Uses WeakHashMap for entity tracking to ensure zero memory leaks during entity despawning.  Asset Structure: Utilizes three distinct texture layers: bar_empty.png, bar_damage.png, and bar1.png.  Project ArchitectureHealthIndicatorMod.java: Handles mod initialization and Forge event bus registration.  HealthRenderEventHandler.java: Manages the core logic for visibility timers, health interpolation, and the rendering loop.  RenderHelper.java: Provides utility methods for vertex-based texture rendering using PoseStack and BufferBuilder.  InstallationVerify that Forge 1.20.1 is installed.  Download the compiled .jar from the Releases section.Place the file into the mods directory of your Minecraft instance.Launch the game.LicenseDistributed under the MIT License. For more details, refer to the mods.toml file within the repository[cite: 4].# Health Indicator

A lightweight, high-performance health bar mod for **Minecraft 1.20.1 (Forge)**. This mod provides a clean combat interface by displaying a health indicator only when necessary, without any configuration menus or clutter[cite: 1, 4].

---

## Key Features

### Dynamic Combat UI
* **Souls-like Visuals**: Implements a three-layer rendering system where a secondary damage bar lingers and gradually fades after a hit, providing clear visual feedback on damage dealt[cite: 2].
* **Contextual Visibility**: The indicator is hidden by default. It only appears when a mob is aggressive, has a target, is currently taking damage, or is a Creeper in its swelling state[cite: 2].
* **Smart Filtering**: Automatically filters out passive mobs (e.g., cows, sheep, villagers) to focus exclusively on hostile threats[cite: 2].

### Technical Excellence
* **Performance Optimized**: Uses a `WeakHashMap` to cache entity data, ensuring automatic memory cleanup when mobs die or despawn[cite: 2].
* **Enhanced Visibility**: Damage numbers are rendered using `LightTexture.FULL_BRIGHT`, making them perfectly visible in caves and during nighttime[cite: 2].
* **Occlusion Handling**: Bars respect line-of-sight and are culled beyond a 20-block radius to maintain immersion and game performance[cite: 2].

---

## Technical Specifications

| Requirement | Value |
| :--- | :--- |
| **Minecraft Version** | 1.20.1[cite: 4] |
| **Mod Loader** | Forge[cite: 1, 4] |
| **Mappings** | Mojang[cite: 2, 3] |
| **Mod ID** | `healthindicator`[cite: 1, 4] |

---

## Installation

1. Install **Forge 1.20.1**[cite: 1, 4].
2. Download the latest `.jar` from the [Releases](https://github.com/NezerX/health-indicator/releases) section.
3. Place the file into your `mods` folder.
4. Launch Minecraft and enjoy the new combat interface.

---

## Development Structure

The project follows a modular architecture for easy maintenance:
* **`HealthIndicatorMod.java`**: Main entry point and event bus registration[cite: 1].
* **`HealthRenderEventHandler.java`**: Handles rendering logic, entity tracking, and visibility conditions[cite: 2].
* **`RenderHelper.java`**: Utility class for low-level texture rendering using `PoseStack` and `BufferBuilder`[cite: 3].

---

## License

This project is licensed under the **MIT License**. See the `mods.toml` file for more details[cite: 4].
