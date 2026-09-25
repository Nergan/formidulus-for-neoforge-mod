package com.formidulus.mod.realtime;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.datagen.Lang;
import java.util.Calendar;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public record TimedEvent(ResourceLocation id, int month, int day, int preMargin, int postMargin) {
   public static final TimedEvent WEEN = new TimedEvent(Formidulus.identifier("ween"), 9, 31, 30, 20);
   public static final TimedEvent SOLSTICE_FESTIVAL = new TimedEvent(Formidulus.identifier("solstice_feast"), 11, 24, 6, 6);

   public int getDaysUntil() {
      Calendar calender = Calendar.getInstance();
      int currentDay = calender.get(6);
      calender.set(2, this.month);
      calender.set(5, this.day);
      int celebration = calender.get(6);
      return celebration - currentDay;
   }

   public boolean isActive(int delta) {
      return delta <= this.preMargin && -delta <= this.postMargin;
   }

   public boolean isActive() {
      return this.isActive(this.getDaysUntil());
   }

   public boolean isToday() {
      return this.getDaysUntil() == 0;
   }

   public String getBaseTranslationKey() {
      return "event." + this.id.getNamespace() + "." + this.id.getPath();
   }

   public String getTitleKey() {
      return this.getBaseTranslationKey() + ".title";
   }

   public String getDescriptionKey() {
      return this.getBaseTranslationKey() + ".description";
   }

   public Component getStateText() {
      Component title = Component.translatable(this.getTitleKey());
      Component activeSuffix = Component.translatable(Lang.EVENT_INFO_ACTIVE_SUFFIX);
      int delta = this.getDaysUntil();
      boolean isActive = this.isActive(delta);
      if (delta == 0) {
         return Component.translatable(Lang.EVENT_INFO_PRESENT, new Object[]{title.getString()});
      } else {
         return delta < 0
            ? Component.translatable(Lang.EVENT_INFO_PAST, new Object[]{title.getString(), -delta})
               .append((Component)(isActive ? activeSuffix : Component.empty()))
            : Component.translatable(Lang.EVENT_INFO_FUTURE, new Object[]{title.getString(), delta})
               .append((Component)(isActive ? activeSuffix : Component.empty()));
      }
   }

   public String getStateStringUntranslated() {
      int delta = this.getDaysUntil();
      boolean isActive = this.isActive(delta);
      if (delta == 0) {
         return String.format("Today is %s!", this.id);
      } else {
         return delta < 0
            ? String.format("%1$s was %2$s days ago.", this.id, -delta) + (isActive ? " (active)" : "")
            : String.format("%1$s is in %2$s days.", this.id, delta) + (isActive ? " (active)" : "");
      }
   }
}
