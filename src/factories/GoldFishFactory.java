package factories;

import fishes.Fish;
import fishes.GoldFish;
import interfaces.IFishAbstractFactory;

public class GoldFishFactory implements IFishAbstractFactory {

    @Override
    public Fish createFish() {
        return new GoldFish();
    }

    public Fish createFish(int x, int y) {
        return new GoldFish(x, y);
    }

}

