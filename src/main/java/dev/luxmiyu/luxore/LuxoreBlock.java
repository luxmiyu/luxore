package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LuxoreBlock extends Block {

    public LuxoreBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(6.0f));
    }

    private double PP(int n) {
        return 0.0625f * (float)n;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape cube = VoxelShapes.cuboid(this.PP(0), this.PP(0), this.PP(0), this.PP(16), this.PP(16), this.PP(16));
        VoxelShape x = VoxelShapes.cuboid(this.PP(0), this.PP(1), this.PP(1), this.PP(16), this.PP(15), this.PP(15));
        VoxelShape y = VoxelShapes.cuboid(this.PP(1), this.PP(0), this.PP(1), this.PP(15), this.PP(16), this.PP(15));
        VoxelShape z = VoxelShapes.cuboid(this.PP(1), this.PP(1), this.PP(0), this.PP(15), this.PP(15), this.PP(16));
        cube = VoxelShapes.combine(cube, x, BooleanBiFunction.ONLY_FIRST);
        cube = VoxelShapes.combine(cube, y, BooleanBiFunction.ONLY_FIRST);
        cube = VoxelShapes.combine(cube, z, BooleanBiFunction.ONLY_FIRST);
        return cube;
    }

}