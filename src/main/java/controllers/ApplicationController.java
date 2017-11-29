/**
 * Copyright (C) 2013 the original author or authors.
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

package controllers;

import models.GameReg;
import models.GameSpan;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;

@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }
    
    public Result gameGetReg(){
        GameReg g = new GameReg();
        g.dealFour();

        return Results.json().render(g);
    }

    public Result gameGetSpan(){
        GameSpan g = new GameSpan();
        g.dealFour();

        return Results.json().render(g);
    }

    public Result dealPost(Context context, GameReg g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        return Results.json().render(g);
    }

    public Result removeCard(Context context, @PathParam("column") int colNumber, GameReg g){
        g.remove(colNumber);
        return Results.json().render(g);
    }

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, GameReg g){
        g.move(colFrom,colTo);
        return Results.json().render(g);
    }

    /*Bottom 2 functions clear the column data from the game, so that refreshing the page is not needed after swapping decks*/
    public Result clearRegColumns(Context context, GameReg g){
        if(context.getRequestPath().contains("clear")){
            g.clearColumns();
        }
        return Results.json().render(g);
    }

    public Result clearSpanColumns(Context context, GameSpan g){
        if(context.getRequestPath().contains("clear")){
            g.clearColumns();
        }
        return Results.json().render(g);
    }

}
