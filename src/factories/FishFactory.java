package factories;

import interfaces.IFishAbstractFactory;

public class FishFactory {

    public enum FishType {
        GOLDFISH, GUPPYFISH
    }

    public IFishAbstractFactory makeFactory(FishType type) {
        switch (type) {
            case GOLDFISH:
                return new GoldFishFactory();
            case GUPPYFISH:
                return new GuppyFishFactory();
            default:
                throw new IllegalArgumentException("FishType not supported.");
        }
    }


}
