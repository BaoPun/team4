/**
 * Copyright (C) 2012 the original author or authors.
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
 */

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of the routes for future assignments.
 */
public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  

        /*New routers were added from the application controller so that supporting functions could be added*/

        router.GET().route("/").with(ApplicationController.class, "index");
        router.GET().route("/gameReg").with(ApplicationController.class, "gameGetReg");
        router.GET().route("/gameSpan").with(ApplicationController.class, "gameGetSpan");
        router.POST().route("/dealGameReg").with(ApplicationController.class, "dealPostReg");
        router.POST().route("/dealGameSpan").with(ApplicationController.class, "dealPostSpan");
        router.POST().route("/moveCardReg/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCardReg");
        router.POST().route("/moveCardSpan/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCardSpan");
        router.POST().route("/removeCardReg/{column}").with(ApplicationController.class, "removeCardReg");
        router.POST().route("/removeCardSpan/{column}").with(ApplicationController.class, "removeCardSpan");
        router.POST().route("/clearReg").with(ApplicationController.class, "clearRegColumns");
        router.POST().route("/clearSpan").with(ApplicationController.class, "clearSpanColumns");

        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
