package com.dfsek.terra.world.population.items.tree;

import com.dfsek.terra.api.block.BlockFace;
import com.dfsek.terra.api.noise.NoiseSampler;
import com.dfsek.terra.api.util.PopulationUtil;
import com.dfsek.terra.api.util.ProbabilityCollection;
import com.dfsek.terra.api.util.Range;
import com.dfsek.terra.api.vector.Vector2;
import com.dfsek.terra.api.vector.Vector3;
import com.dfsek.terra.api.world.Chunk;
import com.dfsek.terra.api.world.Tree;
import com.dfsek.terra.world.population.items.PlaceableLayer;

public class TreeLayer extends PlaceableLayer<Tree> {

    public TreeLayer(double density, Range level, ProbabilityCollection<Tree> layer, NoiseSampler noise) {
        super(density, level, layer, noise);
    }

    @Override
    public void place(Chunk chunk, Vector2 coords) {
        Tree item = layer.get(noise, coords.getX(), coords.getZ());
        Vector3 running = coords.extrude(level.getMax());
        for(int ignored : level) {
            running.subtract(0,1,0);
            if(item.getSpawnable().contains(chunk.getBlockData(running.getBlockX(), running.getBlockY(), running.getBlockZ()).getBlockType())) {
                item.plant(running.toLocation(chunk.getWorld()).add(0, 1, 0), PopulationUtil.getRandom(chunk, coords.hashCode()));
            }
        }
    }
}
