package chapter_4_design_with_lambda.delegation_using_method_ref;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {
    /*to add all the asset values */
    public static int totalAssetValues(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    /*To specifically sum BOND or STOCK we would do*/
    public static int totalBondValues(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getType().equals(Asset.AssetType.BOND))
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalStockValues(final List<Asset> assets) {
        return assets.stream()
                .filter(asset -> asset.getType().equals(Asset.AssetType.STOCK))
                .mapToInt(Asset::getValue)
                .sum();
    }


    /*The above three methods can be boiled down to one
     * with one extra Predicate parameter*/

    /*We've used the open/close principle in this refactored design
    * - we can easily change the selection criteria withoud changing
    * the method.*/
    public static int totalAssetValues(final List<Asset> assets,
                                       final Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }

}
