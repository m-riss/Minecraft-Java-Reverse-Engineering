import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class afb {
   private static final SimpleCommandExceptionType d = new SimpleCommandExceptionType(rq.c("commands.data.merge.failed"));
   private static final DynamicCommandExceptionType e = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.data.get.invalid", $$0);
   });
   private static final DynamicCommandExceptionType f = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.data.get.unknown", $$0);
   });
   private static final SimpleCommandExceptionType g = new SimpleCommandExceptionType(rq.c("commands.data.get.multiple"));
   private static final DynamicCommandExceptionType h = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.data.modify.expected_list", $$0);
   });
   private static final DynamicCommandExceptionType i = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.data.modify.expected_object", $$0);
   });
   private static final DynamicCommandExceptionType j = new DynamicCommandExceptionType(($$0) -> {
      return rq.a("commands.data.modify.invalid_index", $$0);
   });
   public static final List<Function<String, afb.c>> a;
   public static final List<afb.c> b;
   public static final List<afb.c> c;

   public static void a(CommandDispatcher<dr> $$0) {
      LiteralArgumentBuilder<dr> $$1 = (LiteralArgumentBuilder)ds.a("data").requires(($$0x) -> {
         return $$0x.c(2);
      });
      Iterator var2 = b.iterator();

      while(var2.hasNext()) {
         afb.c $$2 = (afb.c)var2.next();
         ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)$$1.then($$2.a(ds.a("merge"), ($$1x) -> {
            return $$1x.then(ds.a((String)"nbt", (ArgumentType)dy.a()).executes(($$1) -> {
               return a((dr)$$1.getSource(), $$2.a($$1), dy.a($$1, "nbt"));
            }));
         }))).then($$2.a(ds.a("get"), ($$1x) -> {
            return $$1x.executes(($$1) -> {
               return a((dr)$$1.getSource(), $$2.a($$1));
            }).then(((RequiredArgumentBuilder)ds.a((String)"path", (ArgumentType)eh.a()).executes(($$1) -> {
               return b((dr)$$1.getSource(), $$2.a($$1), eh.a($$1, "path"));
            })).then(ds.a((String)"scale", (ArgumentType)DoubleArgumentType.doubleArg()).executes(($$1) -> {
               return a((dr)$$1.getSource(), $$2.a($$1), eh.a($$1, "path"), DoubleArgumentType.getDouble($$1, "scale"));
            })));
         }))).then($$2.a(ds.a("remove"), ($$1x) -> {
            return $$1x.then(ds.a((String)"path", (ArgumentType)eh.a()).executes(($$1) -> {
               return a((dr)$$1.getSource(), $$2.a($$1), eh.a($$1, "path"));
            }));
         }))).then(a(($$0x, $$1x) -> {
            $$0x.then(ds.a("insert").then(ds.a((String)"index", (ArgumentType)IntegerArgumentType.integer()).then($$1x.create(($$0, $$1, $$2, $$3) -> {
               int $$4 = IntegerArgumentType.getInteger($$0, "index");
               return a($$4, $$1, $$2, $$3);
            })))).then(ds.a("prepend").then($$1x.create(($$0, $$1, $$2, $$3) -> {
               return a(0, $$1, $$2, $$3);
            }))).then(ds.a("append").then($$1x.create(($$0, $$1, $$2, $$3) -> {
               return a(-1, $$1, $$2, $$3);
            }))).then(ds.a("set").then($$1x.create(($$0, $$1, $$2, $$3) -> {
               qc var10002 = (qc)Iterables.getLast($$3);
               Objects.requireNonNull(var10002);
               return $$2.b($$1, var10002::c);
            }))).then(ds.a("merge").then($$1x.create(($$0, $$1, $$2, $$3) -> {
               Collection<qc> $$4 = $$2.a((qc)$$1, (Supplier)(pj::new));
               int $$5 = 0;

               pj $$7;
               pj $$8;
               for(Iterator var6 = $$4.iterator(); var6.hasNext(); $$5 += $$8.equals($$7) ? 0 : 1) {
                  qc $$6 = (qc)var6.next();
                  if (!($$6 instanceof pj)) {
                     throw i.create($$6);
                  }

                  $$7 = (pj)$$6;
                  $$8 = $$7.g();
                  Iterator var10 = $$3.iterator();

                  while(var10.hasNext()) {
                     qc $$9 = (qc)var10.next();
                     if (!($$9 instanceof pj)) {
                        throw i.create($$9);
                     }

                     $$7.a((pj)$$9);
                  }
               }

               return $$5;
            })));
         }));
      }

      $$0.register($$1);
   }

   private static int a(int $$0, pj $$1, eh.g $$2, List<qc> $$3) throws CommandSyntaxException {
      Collection<qc> $$4 = $$2.a((qc)$$1, (Supplier)(pp::new));
      int $$5 = 0;

      boolean $$7;
      for(Iterator var6 = $$4.iterator(); var6.hasNext(); $$5 += $$7 ? 1 : 0) {
         qc $$6 = (qc)var6.next();
         if (!($$6 instanceof pi)) {
            throw h.create($$6);
         }

         $$7 = false;
         pi<?> $$8 = (pi)$$6;
         int $$9 = $$0 < 0 ? $$8.size() + $$0 + 1 : $$0;
         Iterator var11 = $$3.iterator();

         while(var11.hasNext()) {
            qc $$10 = (qc)var11.next();

            try {
               if ($$8.b($$9, $$10.c())) {
                  ++$$9;
                  $$7 = true;
               }
            } catch (IndexOutOfBoundsException var14) {
               throw j.create($$9);
            }
         }
      }

      return $$5;
   }

   private static ArgumentBuilder<dr, ?> a(BiConsumer<ArgumentBuilder<dr, ?>, afb.b> $$0) {
      LiteralArgumentBuilder<dr> $$1 = ds.a("modify");
      Iterator var2 = b.iterator();

      while(var2.hasNext()) {
         afb.c $$2 = (afb.c)var2.next();
         $$2.a($$1, ($$2x) -> {
            ArgumentBuilder<dr, ?> $$3 = ds.a((String)"targetPath", (ArgumentType)eh.a());
            Iterator var4 = c.iterator();

            while(var4.hasNext()) {
               afb.c $$4 = (afb.c)var4.next();
               $$0.accept($$3, ($$2xx) -> {
                  return $$4.a(ds.a("from"), ($$3) -> {
                     return $$3.executes(($$3x) -> {
                        List<qc> $$4x = Collections.singletonList($$4.a($$3x).a());
                        return a($$3x, $$2, $$2xx, $$4x);
                     }).then(ds.a((String)"sourcePath", (ArgumentType)eh.a()).executes(($$3x) -> {
                        afa $$4x = $$4.a($$3x);
                        eh.g $$5 = eh.a($$3x, "sourcePath");
                        List<qc> $$6 = $$5.a((qc)$$4x.a());
                        return a($$3x, $$2, $$2xx, $$6);
                     }));
                  });
               });
            }

            $$0.accept($$3, ($$1) -> {
               return ds.a("value").then(ds.a((String)"value", (ArgumentType)ei.a()).executes(($$2x) -> {
                  List<qc> $$3 = Collections.singletonList(ei.a($$2x, "value"));
                  return a($$2x, $$2, $$1, $$3);
               }));
            });
            return $$2x.then($$3);
         });
      }

      return $$1;
   }

   private static int a(CommandContext<dr> $$0, afb.c $$1, afb.a $$2, List<qc> $$3) throws CommandSyntaxException {
      afa $$4 = $$1.a($$0);
      eh.g $$5 = eh.a($$0, "targetPath");
      pj $$6 = $$4.a();
      int $$7 = $$2.modify($$0, $$6, $$5, $$3);
      if ($$7 == 0) {
         throw d.create();
      } else {
         $$4.a($$6);
         ((dr)$$0.getSource()).a($$4.b(), true);
         return $$7;
      }
   }

   private static int a(dr $$0, afa $$1, eh.g $$2) throws CommandSyntaxException {
      pj $$3 = $$1.a();
      int $$4 = $$2.c($$3);
      if ($$4 == 0) {
         throw d.create();
      } else {
         $$1.a($$3);
         $$0.a($$1.b(), true);
         return $$4;
      }
   }

   private static qc a(eh.g $$0, afa $$1) throws CommandSyntaxException {
      Collection<qc> $$2 = $$0.a((qc)$$1.a());
      Iterator<qc> $$3 = $$2.iterator();
      qc $$4 = (qc)$$3.next();
      if ($$3.hasNext()) {
         throw g.create();
      } else {
         return $$4;
      }
   }

   private static int b(dr $$0, afa $$1, eh.g $$2) throws CommandSyntaxException {
      qc $$3 = a($$2, $$1);
      int $$8;
      if ($$3 instanceof pw) {
         $$8 = ami.b(((pw)$$3).i());
      } else if ($$3 instanceof pi) {
         $$8 = ((pi)$$3).size();
      } else if ($$3 instanceof pj) {
         $$8 = ((pj)$$3).e();
      } else {
         if (!($$3 instanceof qa)) {
            throw f.create($$2.toString());
         }

         $$8 = $$3.e_().length();
      }

      $$0.a($$1.a($$3), false);
      return $$8;
   }

   private static int a(dr $$0, afa $$1, eh.g $$2, double $$3) throws CommandSyntaxException {
      qc $$4 = a($$2, $$1);
      if (!($$4 instanceof pw)) {
         throw e.create($$2.toString());
      } else {
         int $$5 = ami.b(((pw)$$4).i() * $$3);
         $$0.a($$1.a($$2, $$3, $$5), false);
         return $$5;
      }
   }

   private static int a(dr $$0, afa $$1) throws CommandSyntaxException {
      $$0.a($$1.a((qc)$$1.a()), false);
      return 1;
   }

   private static int a(dr $$0, afa $$1, pj $$2) throws CommandSyntaxException {
      pj $$3 = $$1.a();
      pj $$4 = $$3.g().a($$2);
      if ($$3.equals($$4)) {
         throw d.create();
      } else {
         $$1.a($$4);
         $$0.a($$1.b(), true);
         return 1;
      }
   }

   static {
      a = ImmutableList.of(afc.a, aez.a, afd.a);
      b = (List)a.stream().map(($$0) -> {
         return (afb.c)$$0.apply("target");
      }).collect(ImmutableList.toImmutableList());
      c = (List)a.stream().map(($$0) -> {
         return (afb.c)$$0.apply("source");
      }).collect(ImmutableList.toImmutableList());
   }

   public interface c {
      afa a(CommandContext<dr> var1) throws CommandSyntaxException;

      ArgumentBuilder<dr, ?> a(ArgumentBuilder<dr, ?> var1, Function<ArgumentBuilder<dr, ?>, ArgumentBuilder<dr, ?>> var2);
   }

   private interface a {
      int modify(CommandContext<dr> var1, pj var2, eh.g var3, List<qc> var4) throws CommandSyntaxException;
   }

   private interface b {
      ArgumentBuilder<dr, ?> create(afb.a var1);
   }
}
