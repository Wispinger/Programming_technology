package factories;

import fishes.Fish;
import fishes.GuppyFish;
import interfaces.IFishAbstractFactory;

public class GuppyFishFactory implements IFishAbstractFactory {

    @Override
    public Fish createFish() {
        return new GuppyFish();
    }

    public Fish createFish(int x, int y) {
        return new GuppyFish(x, y);
    }

}

