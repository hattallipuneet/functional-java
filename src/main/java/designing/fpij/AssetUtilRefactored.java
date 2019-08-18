package designing.fpij;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtilRefactored {

    private AssetUtilRefactored() {}


    public static int totalAssetValues(final List<Asset> assets, Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getAssetValue)
                .sum();
    }
}
