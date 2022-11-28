import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Function;

public class afc implements afa {
   private static final SimpleCommandExceptionType b = new SimpleCommandExceptionType(rq.c("commands.data.entity.invalid"));
   public static final Function<String, afb.c> a = ($$0) -> {
      return new afb.c() {
         public afa a(CommandContext<dr> $$0x) throws CommandSyntaxException {
            return new afc(eb.a($$0x, $$0));
         }

         public ArgumentBuilder<dr, ?> a(ArgumentBuilder<dr, ?> $$0x, Function<ArgumentBuilder<dr, ?>, ArgumentBuilder<dr, ?>> $$1) {
            return $$0x.then(ds.a("entity").then((ArgumentBuilder)$$1.apply(ds.a((String)$$0, (ArgumentType)eb.a()))));
         }
      };
   };
   private final bbn c;

   public afc(bbn $$0) {
      this.c = $$0;
   }

   public void a(pj $$0) throws CommandSyntaxException {
      if (this.c instanceof buc) {
         throw b.create();
      } else {
         UUID $$1 = this.c.co();
         this.c.g($$0);
         this.c.a_($$1);
      }
   }

   public pj a() {
      return cl.b(this.c);
   }

   public rq b() {
      return rq.a("commands.data.entity.modified", this.c.C_());
   }

   public rq a(qc $$0) {
      return rq.a("commands.data.entity.query", this.c.C_(), pv.c($$0));
   }

   public rq a(eh.g $$0, double $$1, int $$2) {
      return rq.a("commands.data.entity.get", $$0, this.c.C_(), String.format(Locale.ROOT, "%.2f", $$1), $$2);
   }
}
