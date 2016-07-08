/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.dynamicCities.buildings;


import org.terasology.assets.Asset;
import org.terasology.assets.AssetType;
import org.terasology.assets.ResourceUrn;
import org.terasology.assets.module.annotations.RegisterAssetType;

@RegisterAssetType(folderName = "buildings", factoryClass = GenericBuildingFactory.class)
public class GenericBuilding extends Asset<GenericBuildingData> {

    /**
     *  Can either store a composite genericBuildingData from the module cities
     *  or a structured template
     */
    private boolean isComposite;
    private String compositeGenerator;

    public GenericBuilding(ResourceUrn urn, AssetType<?, GenericBuildingData> type, GenericBuildingData data) {
        super(urn, type);
        reload(data);
    }

    public String asComposite() {
        if (isComposite) {
            return compositeGenerator;
        } else {
            return null;
        }
    }

    public boolean isComposite() {
        return isComposite;
    }


    @Override
    protected void doReload(GenericBuildingData data) {
        isComposite = data.isComposite();
        if (isComposite) {
            compositeGenerator = data.asComposite();
        }
    }

}
