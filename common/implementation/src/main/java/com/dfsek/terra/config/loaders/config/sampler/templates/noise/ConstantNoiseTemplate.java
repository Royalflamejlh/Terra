package com.dfsek.terra.config.loaders.config.sampler.templates.noise;

import com.dfsek.tectonic.annotations.Default;
import com.dfsek.tectonic.annotations.Value;
import com.dfsek.terra.api.noise.NoiseSampler;
import com.dfsek.terra.config.loaders.config.sampler.templates.SamplerTemplate;
import com.dfsek.terra.noise.samplers.noise.ConstantSampler;

@SuppressWarnings("FieldMayBeFinal")
public class ConstantNoiseTemplate extends SamplerTemplate<ConstantSampler> {
    @Value("value")
    @Default
    private double value = 0d;

    @Override
    public NoiseSampler apply(Long seed) {
        return new ConstantSampler(value);
    }
}
