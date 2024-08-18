/*
 * Copyright (c)  2024 kamillion-suite contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 12.08.2024
 */

package org.kamillion.hateoflux.assembler;

import org.kamillion.hateoflux.model.hal.HalListWrapper;
import org.kamillion.hateoflux.model.link.Link;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Younes El Ouarti
 */
public sealed interface SealedEntityListAssemblerModule<EntityT, EmbeddedT> permits
        FlatHalWrapperAssembler, EmbeddingHalWrapperAssembler {


    default HalListWrapper<EntityT, EmbeddedT> createEmptyListWrapper(Class<?> listItemTypeAsNameOrigin,
                                                                      ServerWebExchange exchange) {
        HalListWrapper<EntityT, EmbeddedT> emptyWrapper = HalListWrapper.empty(listItemTypeAsNameOrigin);
        return emptyWrapper
                .withLinks(buildLinksForEntityList(exchange));
    }

    default HalListWrapper<EntityT, EmbeddedT> createEmptyListWrapper(String listName, ServerWebExchange exchange) {
        HalListWrapper<EntityT, EmbeddedT> emptyWrapper = HalListWrapper.empty(listName);
        return emptyWrapper
                .withLinks(buildLinksForEntityList(exchange));
    }

    default List<Link> buildLinksForEntityList(ServerWebExchange exchange) {
        List<Link> links = new ArrayList<>();
        links.add(buildSelfLinkForEntityList(exchange));
        links.addAll(buildOtherLinksForEntityList(exchange));
        return links;
    }

    default List<Link> buildOtherLinksForEntityList(ServerWebExchange exchange) {
        return List.of();
    }

    Link buildSelfLinkForEntityList(ServerWebExchange exchange);
}
