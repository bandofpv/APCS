//  StarsApplet.java  Copyright (c) Kari Laitinen

//  http://www.naturalprogramming.com

//  2008-01-12  This file was created.
//  2010-01-28  Latest modification. This is now a JPanel-based applet.

/*  This program 
       - demonstrates the use of Java 2D graphics
       - demonstrates the use of class GeneralPath
       - provides classes that can represent star shapes on the screen

    More notes at the end of this file.
*/

import java.awt.* ;
import javax.swing.* ;
import java.awt.geom.* ; //  Classes GeneralPath etc.

abstract class StarShape
{
   int star_center_point_x, star_center_point_y ;
   int star_radius  = (int)((0.0616 / 2) * 400) ; // the radius of the bounding circle 

   Color   star_color     = Color.YELLOW ;
   boolean star_is_hollow = false ;

   public abstract void draw( Graphics graphics ) ;
}

//  The following class represents a 5-point star

class StarShape5 extends StarShape
{
   public StarShape5( int given_star_center_point_x,
                      int given_star_center_point_y )
   {
      star_center_point_x  =  given_star_center_point_x ;
      star_center_point_y  =  given_star_center_point_y ;
   }

   public StarShape5( int given_star_center_point_x,
                      int given_star_center_point_y,
                      int given_star_radius,
                      Color   given_star_color,
                      boolean given_hollowness )
   {
      star_center_point_x  =  given_star_center_point_x ;
      star_center_point_y  =  given_star_center_point_y ;
      star_radius          =  given_star_radius ;
      star_color           =  given_star_color ;
      star_is_hollow       =  given_hollowness ;
   }


   public void draw( Graphics graphics )
   {
      Graphics2D  graphics2D  =  (Graphics2D) graphics ;

      AffineTransform  saved_graphics_transform  =  graphics2D.getTransform() ;

      graphics2D.translate( star_center_point_x,
                            star_center_point_y ) ;  

      GeneralPath star_shape_5  =  new GeneralPath() ;

      //  The following coordinates are fixed supposing that the
      //  radius of the star is 80 pixels (points).
      //  Larger or smaller stars are drawn by adjusting the scale of
      //  the coordinate system. If you want to change the default
      //  star radius (80 points), you must modify these coordinates
      //  as well.

      star_shape_5.moveTo(  76.08F, -24.72F ) ; // start from upper right point
      star_shape_5.lineTo( -47.02F,  64.72F ) ; // to lower left point
      star_shape_5.lineTo(   0,     -80.0F  ) ; // to upper middle point
      star_shape_5.lineTo(  47.02F,  64.72F ) ; // to lower right point
      star_shape_5.lineTo( -76.08F, -24.72F ) ; // to upper left point
      star_shape_5.closePath() ;                // to upper right point

      graphics2D.setColor( star_color ) ;
      graphics2D.scale( star_radius / 80.0, star_radius / 80.0 ) ;

      if ( star_is_hollow == true )
      {
         Stroke saved_stroke  =  graphics2D.getStroke() ;
         graphics2D.setStroke( new BasicStroke( 4 ) ) ;
         graphics2D.draw( star_shape_5 ) ;
         graphics2D.setStroke( saved_stroke ) ;
      }
      else
      {
         graphics2D.fill( star_shape_5 ) ;
      }

      graphics2D.setTransform( saved_graphics_transform ) ;
   }
}

//  The following class represents a 6-point star

class StarShape6 extends StarShape
{
   public StarShape6( int given_star_center_point_x,
                      int given_star_center_point_y )
   {
      star_center_point_x  =  given_star_center_point_x ;
      star_center_point_y  =  given_star_center_point_y ;
   }

   public StarShape6( int given_star_center_point_x,
                      int given_star_center_point_y,
                      int given_star_radius,
                      Color   given_star_color,
                      boolean given_hollowness )
   {
      star_center_point_x  =  given_star_center_point_x ;
      star_center_point_y  =  given_star_center_point_y ;
      star_radius          =  given_star_radius ;
      star_color           =  given_star_color ;
      star_is_hollow       =  given_hollowness ;
   }


   public void draw( Graphics graphics )
   {
      Graphics2D  graphics2D  =  (Graphics2D) graphics ;

      AffineTransform  saved_graphics_transform  =  graphics2D.getTransform() ;

      graphics2D.translate( star_center_point_x,
                            star_center_point_y ) ;  

      GeneralPath star_6_triangle  =  new GeneralPath() ;

      //  A six-point star will be drawn by drawing two triangles, so
      //  that the coordinate system is rotated 180 degrees between drawings.

      //  The following coordinates are fixed supposing that the
      //  radius of the star is 80 pixels (points).
      //  Larger or smaller stars are drawn by adjusting the scale of
      //  the coordinate system. If you want to change the default
      //  star radius (80 points), you must modify these coordinates
      //  as well.

      star_6_triangle.moveTo(   0,     -80.0F ) ; // start from the top point
      star_6_triangle.lineTo(  69.28F,  40.0F ) ; // to lower right point
      star_6_triangle.lineTo( -69.28F,  40.0F ) ; // to lower left point
      star_6_triangle.closePath() ;               // back to top point

      graphics2D.setColor( star_color ) ;
      graphics2D.scale( star_radius / 80.0, star_radius / 80.0 ) ;

      if ( star_is_hollow == true )
      {
         Stroke saved_stroke  =  graphics2D.getStroke() ;
         graphics2D.setStroke( new BasicStroke( 4 ) ) ;
         graphics2D.draw( star_6_triangle ) ;
         graphics2D.rotate( Math.PI ) ;  // 180 degrees clockwise
         graphics2D.draw( star_6_triangle ) ;
         graphics2D.setStroke( saved_stroke ) ;
      }
      else
      {
         graphics2D.fill( star_6_triangle ) ;
         graphics2D.rotate( Math.PI ) ;  // 180 degrees clockwise
         graphics2D.fill( star_6_triangle ) ;
      }

      graphics2D.setTransform( saved_graphics_transform ) ;
   }
}


class StarsPanel extends JPanel
{
   //  Some of the stars defined below have the same position on the screen.
   //  For example, both the large pink star and the small red star 
   //  have their center point at (300,300). The small red star is thus
   //  drawn inside the larger pink star.

   StarShape5  default_star_5    =  new StarShape5( 100, 300 ) ;
   StarShape5  large_pink_star_5 =  new StarShape5( 300, 300,
                                                    120, Color.PINK, false ) ;
   StarShape5  small_red_star_5  =  new StarShape5( 300, 300,
                                                     50, Color.RED, false ) ;
   StarShape5  hollow_star_5   =  new StarShape5( 500, 300,
                                                   60, Color.WHITE, true ) ;

   StarShape6  larger_star_6   =  new StarShape6( 700, 300,
                                                  100, Color.MAGENTA, false ) ;
   StarShape6  smaller_star_6  =  new StarShape6( 700, 300,
                                                   60, Color.BLACK, true ) ;


   public StarsPanel()
   {
      setBackground( Color.DARK_GRAY ) ;
   }

   public void paintComponent( Graphics graphics )
   {
      super.paintComponent( graphics ) ;

      default_star_5.draw( graphics ) ;
      large_pink_star_5.draw( graphics ) ;
      small_red_star_5.draw( graphics ) ;
      hollow_star_5.draw( graphics ) ;

      larger_star_6.draw( graphics ) ;
      smaller_star_6.draw( graphics ) ;
   }

}

public class StarsApplet extends JApplet
{
   public void init()
   {
      getContentPane().add( new StarsPanel() ) ; 
   }
}



/*
   NOTE:

   If you would like to draw stars that have 10 or 12 points,
   one possibility is to draw two 5- or 6-point stars so that
   the coordinate system is rotated between drawings.
   You could define the following members to a star class:


   double current_star_rotation = 0.0 ;

   public void rotate_star( double given_rotation )
   {
      current_star_rotation = current_star_rotation + given_rotation ;
   }

   Then you should have the following statement in the draw() method:

      graphics2D.rotate( current_star_rotation ) ;

   Having done these enhancements you could draw a 10-point
   star in the following way:

      default_star_5.draw( graphics ) ;
      default_star_5.rotate_star( Math.PI / 5 ) ;
      default_star_5.draw( graphics ) ;


   NOTE:

      // A StarShape5 can be roughly drawn with the following lines,
      // but the quality of drawing is not "star quality".

      // We first define a suitable triangle, which will be used
      // to draw a star. The triangle will be drawn three times and
      // the coordinate system is rotated by one 5th of a full circle
      // between drawings. 

      GeneralPath triangle_shape = new GeneralPath();

      triangle_shape.moveTo(  76.08F, -24.72F ) ; 
      triangle_shape.lineTo(   0,      34.75F ) ; 
      triangle_shape.lineTo( -76.08F, -24.72F ) ; 
      triangle_shape.closePath() ;

      graphics2D.fill( triangle_shape ) ;
      graphics2D.rotate( 2 * Math.PI / 5 ) ;
      graphics2D.fill( triangle_shape ) ;
      graphics2D.rotate( 2 * Math.PI / 5 ) ;
      graphics2D.fill( triangle_shape ) ;
*/
