/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view.utils;

import com.upemor.appchecador.utils.Utils;
import com.vaadin.server.DownloadStream;
import com.vaadin.server.FileResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

/*
@author cerimice
@Company Tiamex
*/

public class FileDownloadResource extends FileResource{
    
    public FileDownloadResource(File sourceFile){
        super(sourceFile);
    }
    
    @Override
    public DownloadStream getStream(){
        try{
            final DownloadStream ds = new DownloadStream(new FileInputStream(getSourceFile()),getMIMEType(),getFilename());
            ds.setParameter("Content-Disposition", "attachment; filename=" + getFilename());
            ds.setCacheTime(getCacheTime());
            return ds;
        }catch(final FileNotFoundException ex){
        Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.getMessage());
        return null;
        }
    }
}