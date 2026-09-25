package com.formidulus.mod.components.entity;

import com.formidulus.mod.entities.BulwarkEntity;

public interface IBulwarkComponent {
   void setBulwark(BulwarkEntity entity);

   BulwarkEntity getBulwarkEntity();

   boolean hasBulwark();

   float getBulwarkYaw();

   void onBulwarkBreak();
}
