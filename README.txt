# Health Indicator

A lightweight, high-performance health bar mod for **Minecraft 1.20.1 (Forge)**. It provides a clean combat interface by displaying a health indicator only when necessary, avoiding configuration menus and UI clutter[cite: 1, 4].

---

## Features

### Dynamic Combat UI
* **Souls-like Visuals**: Implements a three-layer rendering system where a secondary damage bar lingers and gradually fades after a hit, providing clear visual feedback[cite: 2].
* **Contextual Visibility**: The indicator only appears when a mob is aggressive, has a target, is taking damage, or is a Creeper in its swelling state[cite: 2].
* **Smart Filtering**: Automatically ignores passive mobs (cows, sheep, villagers) to focus exclusively on hostile threats[cite: 2].

### Technical Implementation
* **Performance Optimized**: Uses a `WeakHashMap` to cache entity data, ensuring automatic memory cleanup when mobs die or despawn[cite: 2].
* **High Contrast Text**: Damage numbers are rendered using `LightTexture.FULL_BRIGHT`, ensuring perfect visibility in caves and at night[cite: 2].
* **Smart Occlusion**: Bars respect line-of-sight and are culled beyond a 20-block radius to maintain immersion and performance[cite: 2].

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
4. Launch Minecraft and start hunting.

---

## Project Structure

* **`HealthIndicatorMod.java`**: Main entry point and event bus registration[cite: 1].
* **`HealthRenderEventHandler.java`**: Core logic for visibility, Souls-like interpolation, and damage tracking[cite: 2].
* **`RenderHelper.java`**: Utility class for low-level texture rendering using `PoseStack` and `BufferBuilder`[cite: 3].

---

## License

This project is licensed under the **MIT License**. See the `mods.toml` file for details[cite: 4].
