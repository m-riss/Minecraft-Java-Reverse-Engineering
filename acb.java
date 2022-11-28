import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class acb {
   private static final SuggestionProvider<dr> a = ($$0, $$1) -> {
      Collection<af> $$2 = ((dr)$$0.getSource()).m().az().a();
      return dt.a($$2.stream().map(af::h), $$1);
   };

   public static void a(CommandDispatcher<dr> $$0) {
      $$0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ds.a("advancement").requires(($$0x) -> {
         return $$0x.c(2);
      })).then(ds.a("grant").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.d()).then(ds.a("only").then(((RequiredArgumentBuilder)ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, a(eq.a($$0x, "advancement"), acb.b.a));
      })).then(ds.a((String)"criterion", (ArgumentType)StringArgumentType.greedyString()).suggests(($$0x, $$1) -> {
         return dt.b((Iterable)eq.a($$0x, "advancement").f().keySet(), (SuggestionsBuilder)$$1);
      }).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, eq.a($$0x, "advancement"), StringArgumentType.getString($$0x, "criterion"));
      }))))).then(ds.a("from").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, a(eq.a($$0x, "advancement"), acb.b.c));
      })))).then(ds.a("until").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, a(eq.a($$0x, "advancement"), acb.b.d));
      })))).then(ds.a("through").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, a(eq.a($$0x, "advancement"), acb.b.b));
      })))).then(ds.a("everything").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.a, ((dr)$$0x.getSource()).m().az().a());
      }))))).then(ds.a("revoke").then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)ds.a((String)"targets", (ArgumentType)eb.d()).then(ds.a("only").then(((RequiredArgumentBuilder)ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, a(eq.a($$0x, "advancement"), acb.b.a));
      })).then(ds.a((String)"criterion", (ArgumentType)StringArgumentType.greedyString()).suggests(($$0x, $$1) -> {
         return dt.b((Iterable)eq.a($$0x, "advancement").f().keySet(), (SuggestionsBuilder)$$1);
      }).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, eq.a($$0x, "advancement"), StringArgumentType.getString($$0x, "criterion"));
      }))))).then(ds.a("from").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, a(eq.a($$0x, "advancement"), acb.b.c));
      })))).then(ds.a("until").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, a(eq.a($$0x, "advancement"), acb.b.d));
      })))).then(ds.a("through").then(ds.a((String)"advancement", (ArgumentType)eq.a()).suggests(a).executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, a(eq.a($$0x, "advancement"), acb.b.b));
      })))).then(ds.a("everything").executes(($$0x) -> {
         return a((dr)$$0x.getSource(), eb.f($$0x, "targets"), acb.a.b, ((dr)$$0x.getSource()).m().az().a());
      })))));
   }

   private static int a(dr $$0, Collection<agh> $$1, acb.a $$2, Collection<af> $$3) {
      int $$4 = 0;

      agh $$5;
      for(Iterator var5 = $$1.iterator(); var5.hasNext(); $$4 += $$2.a($$5, (Iterable)$$3)) {
         $$5 = (agh)var5.next();
      }

      if ($$4 == 0) {
         if ($$3.size() == 1) {
            if ($$1.size() == 1) {
               throw new dn(rq.a($$2.a() + ".one.to.one.failure", ((af)$$3.iterator().next()).j(), ((agh)$$1.iterator().next()).C_()));
            } else {
               throw new dn(rq.a($$2.a() + ".one.to.many.failure", ((af)$$3.iterator().next()).j(), $$1.size()));
            }
         } else if ($$1.size() == 1) {
            throw new dn(rq.a($$2.a() + ".many.to.one.failure", $$3.size(), ((agh)$$1.iterator().next()).C_()));
         } else {
            throw new dn(rq.a($$2.a() + ".many.to.many.failure", $$3.size(), $$1.size()));
         }
      } else {
         if ($$3.size() == 1) {
            if ($$1.size() == 1) {
               $$0.a(rq.a($$2.a() + ".one.to.one.success", ((af)$$3.iterator().next()).j(), ((agh)$$1.iterator().next()).C_()), true);
            } else {
               $$0.a(rq.a($$2.a() + ".one.to.many.success", ((af)$$3.iterator().next()).j(), $$1.size()), true);
            }
         } else if ($$1.size() == 1) {
            $$0.a(rq.a($$2.a() + ".many.to.one.success", $$3.size(), ((agh)$$1.iterator().next()).C_()), true);
         } else {
            $$0.a(rq.a($$2.a() + ".many.to.many.success", $$3.size(), $$1.size()), true);
         }

         return $$4;
      }
   }

   private static int a(dr $$0, Collection<agh> $$1, acb.a $$2, af $$3, String $$4) {
      int $$5 = 0;
      if (!$$3.f().containsKey($$4)) {
         throw new dn(rq.a("commands.advancement.criterionNotFound", $$3.j(), $$4));
      } else {
         Iterator var6 = $$1.iterator();

         while(var6.hasNext()) {
            agh $$6 = (agh)var6.next();
            if ($$2.a($$6, $$3, $$4)) {
               ++$$5;
            }
         }

         if ($$5 == 0) {
            if ($$1.size() == 1) {
               throw new dn(rq.a($$2.a() + ".criterion.to.one.failure", $$4, $$3.j(), ((agh)$$1.iterator().next()).C_()));
            } else {
               throw new dn(rq.a($$2.a() + ".criterion.to.many.failure", $$4, $$3.j(), $$1.size()));
            }
         } else {
            if ($$1.size() == 1) {
               $$0.a(rq.a($$2.a() + ".criterion.to.one.success", $$4, $$3.j(), ((agh)$$1.iterator().next()).C_()), true);
            } else {
               $$0.a(rq.a($$2.a() + ".criterion.to.many.success", $$4, $$3.j(), $$1.size()), true);
            }

            return $$5;
         }
      }
   }

   private static List<af> a(af $$0, acb.b $$1) {
      List<af> $$2 = Lists.newArrayList();
      if ($$1.f) {
         for(af $$3 = $$0.b(); $$3 != null; $$3 = $$3.b()) {
            $$2.add($$3);
         }
      }

      $$2.add($$0);
      if ($$1.g) {
         a((af)$$0, (List)$$2);
      }

      return $$2;
   }

   private static void a(af $$0, List<af> $$1) {
      Iterator var2 = $$0.e().iterator();

      while(var2.hasNext()) {
         af $$2 = (af)var2.next();
         $$1.add($$2);
         a($$2, $$1);
      }

   }

   static enum a {
      a("grant") {
         protected boolean a(agh $$0, af $$1) {
            ah $$2 = $$0.M().b($$1);
            if ($$2.a()) {
               return false;
            } else {
               Iterator var4 = $$2.e().iterator();

               while(var4.hasNext()) {
                  String $$3 = (String)var4.next();
                  $$0.M().a($$1, $$3);
               }

               return true;
            }
         }

         protected boolean a(agh $$0, af $$1, String $$2) {
            return $$0.M().a($$1, $$2);
         }
      },
      b("revoke") {
         protected boolean a(agh $$0, af $$1) {
            ah $$2 = $$0.M().b($$1);
            if (!$$2.b()) {
               return false;
            } else {
               Iterator var4 = $$2.f().iterator();

               while(var4.hasNext()) {
                  String $$3 = (String)var4.next();
                  $$0.M().b($$1, $$3);
               }

               return true;
            }
         }

         protected boolean a(agh $$0, af $$1, String $$2) {
            return $$0.M().b($$1, $$2);
         }
      };

      private final String c;

      a(String $$0) {
         this.c = "commands.advancement." + $$0;
      }

      public int a(agh $$0, Iterable<af> $$1) {
         int $$2 = 0;
         Iterator var4 = $$1.iterator();

         while(var4.hasNext()) {
            af $$3 = (af)var4.next();
            if (this.a($$0, $$3)) {
               ++$$2;
            }
         }

         return $$2;
      }

      protected abstract boolean a(agh var1, af var2);

      protected abstract boolean a(agh var1, af var2, String var3);

      protected String a() {
         return this.c;
      }

      // $FF: synthetic method
      private static acb.a[] b() {
         return new acb.a[]{a, b};
      }
   }

   static enum b {
      a(false, false),
      b(true, true),
      c(false, true),
      d(true, false),
      e(true, true);

      final boolean f;
      final boolean g;

      private b(boolean $$0, boolean $$1) {
         this.f = $$0;
         this.g = $$1;
      }

      // $FF: synthetic method
      private static acb.b[] a() {
         return new acb.b[]{a, b, c, d, e};
      }
   }
}
