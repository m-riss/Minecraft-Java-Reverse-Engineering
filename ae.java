import com.mojang.bridge.game.GameVersion;

public interface ae extends GameVersion {
   /** @deprecated */
   @Deprecated
   default int getWorldVersion() {
      return this.b().c();
   }

   /** @deprecated */
   @Deprecated
   default String getSeriesId() {
      return this.b().b();
   }

   drk b();
}
