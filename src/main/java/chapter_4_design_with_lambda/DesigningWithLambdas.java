package chapter_4_design_with_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DesigningWithLambdas {
    /*
     * We can replace interfaces, class hierarchies, and
     * anonymous inner classes with concise code.
     * We will use:
     * -> lightweight functions instead of objects
     * -> lambda expressions to easily separate logic form function
     * -> delegate responsibilities and implement the decorator pattern */
    public static void main(String[] args) {

        final List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );

        /*this is simple use of strategy pattern - to separate
        * a concern from a method*/
        final Predicate<Asset> allBonds = asset -> asset.getType().equals(Asset.AssetType.BOND);
        final Predicate<Asset> allStocks = asset -> asset.getType().equals(Asset.AssetType.STOCK);
        final Predicate<Asset> allAssets = asset -> true;

        System.out.println("Total Asset value:\t" + AssetUtil.totalAssetValues(assets,allAssets));
        System.out.println("Total Bond value:\t" + AssetUtil.totalAssetValues(assets, allBonds));
        System.out.println("Total Stock value:\t" + AssetUtil.totalAssetValues(assets, allStocks));

    }
}
