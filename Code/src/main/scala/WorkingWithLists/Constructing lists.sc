// All lists are built from two fundamental blocks:
// Nil and :: ("cons"), where Nil is the empty list
// :: expresses list extension at the head
val fruits = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val diag3 = (1 :: (0 :: (0 :: Nil)))
  :: (0 :: (1 :: (0 :: Nil)))
  :: (0 :: (0 :: (1 :: Nil)))
  :: Nil
val empty = Nil
// List(1,2,3) creates a the list 1 :: (2 :: (3 :: Nil))
// :: is right associative meaning A :: B :: C == A :: (B :: C)