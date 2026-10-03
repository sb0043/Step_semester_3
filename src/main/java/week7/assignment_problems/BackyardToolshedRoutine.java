package week7.assignment_problems;

abstract class GardenTool {
    public String use() {
        return "Using the tool in the garden";
    }
}

class CuttingTool extends GardenTool {
    @Override
    public String use() {
        return super.use() + ", blade sharpened first";
    }
}

class Pruner extends CuttingTool {
    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

public class BackyardToolshedRoutine {

    public static void main(String[] args) {
        GardenTool tool = new Pruner();

        System.out.println(tool.use());
    }
}