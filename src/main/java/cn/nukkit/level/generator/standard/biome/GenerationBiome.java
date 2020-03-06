package cn.nukkit.level.generator.standard.biome;

import cn.nukkit.level.generator.standard.gen.decorator.Decorator;
import cn.nukkit.level.generator.standard.pop.Populator;
import cn.nukkit.level.generator.standard.store.GenerationBiomeStore;
import cn.nukkit.utils.Identifier;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NonNull;

import static net.daporkchop.lib.common.util.PorkUtil.*;

/**
 * Representation of a biome used during terrain generation.
 *
 * @author DaPorkchop_
 */
@JsonDeserialize(using = GenerationBiomeDeserializer.class)
public final class GenerationBiome {
    private final Identifier      id;
    private final BiomeDictionary dictionary;

    private final Decorator[] decorators;
    private final Populator[] populators;

    private final double baseHeight;
    private final double heightVariation;

    private final double temperature;
    private final double rainfall;

    private final int runtimeId;

    public GenerationBiome(@NonNull GenerationBiomeStore.TempBiome temp, @NonNull Identifier id) {
        this.id = id;
        this.dictionary = temp.getDictionary();
        this.decorators = fallbackIfNull(temp.getDecorators(), Decorator.EMPTY_ARRAY);
        this.populators = fallbackIfNull(temp.getPopulators(), Populator.EMPTY_ARRAY);

        this.baseHeight = temp.getBaseHeight();
        this.heightVariation = temp.getHeightVariation();

        this.temperature = temp.getTemperature();
        this.rainfall = temp.getRainfall();

        this.runtimeId = this.dictionary.get(id);
    }

    public Identifier getId() {
        return this.id;
    }

    public BiomeDictionary getDictionary() {
        return this.dictionary;
    }

    public Decorator[] getDecorators() {
        return this.decorators;
    }

    public Populator[] getPopulators() {
        return this.populators;
    }

    public double getBaseHeight() {
        return this.baseHeight;
    }

    public double getHeightVariation() {
        return this.heightVariation;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getRainfall() {
        return this.rainfall;
    }

    public int getRuntimeId() {
        return this.runtimeId;
    }
}