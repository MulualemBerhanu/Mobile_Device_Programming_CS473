package com.inifiny.walmart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_detail.*


class CategoryDetail:DialogFragment() {
    lateinit var recyclerView:RecyclerView;
    var products= arrayListOf<Product>(Product("Apple iPhone 13 Pro Max (256GB, Graphite) [Locked] + Carrier Subscription","$1,199.00& FREE Shipping.","Space Gray",R.drawable.mac,"All-Day Battery Life – Go longer than ever with up to 18 hours of battery life.\n" +
            "Powerful Performance – Take on everything from professional-quality editing to action-packed gaming with ease. The Apple M1 chip with an 8-core CPU delivers up to 3.5x faster performance than the previous generation while using way less power.\n" +
            "Superfast Memory – 8GB of unified memory makes your entire system speedy and responsive. That way it can support tasks like memory-hogging multitab browsing and opening a huge graphic file quickly and easily.\n" +
            "Stunning Display – With a 13.3” Retina display, images come alive with new levels of realism. Text is sharp and clear, and colors are more vibrant.\n" +
            "Why Mac – Easy to learn. Easy to set up. Astoundingly powerful. Intuitive. Packed with apps to use right out of the box. Mac is designed to let you work, play, and create like never before.\n" +
            "Simply Compatible – All your existing apps work, including Adobe Creative Cloud, Microsoft 365, and Google Drive. Plus you can use your favorite iPhone and iPad apps directly on macOS. Altogether you’ll have access to the biggest collection of apps ever for Mac. All available on the App Store.\n" +
            "Easy to Learn – If you already have an iPhone, MacBook Air feels familiar from the moment you turn it on. And it works perfectly with all your Apple devices. Use your iPad to extend the workspace of your Mac, answer texts and phone calls directly on your Mac, and more."),
        Product("4DV4 RC Drone with 1080P HD Camera for adults and Kids, FPV Live Video Foldable RC Quadcopter Helicopter Beginners Toys, 2 Batteries, Waypoints Functions, Headless Mode,One Key Start, Altitude Hold","$89.99","Black",R.drawable.webcam,"Full HD 1080p video calling and recording at 30 fps - You’ll make a strong impression when it counts with crisp, clearly detailed and vibrantly colored video.\n" +
                "1080P pictures & Videos and FPV Function】Upgrade dual camera, switch the Angle of view arbitrarily. including adjustable angle, which captures high-quality video and clear aerial photos.you can see what your drone sees from smartphone, enjoy a live video feed up from 80m away with FPV transmission.\n" +
                "Advanced capture software – Create and share video content easily with Logitech Capture.\n" +
                "HD lighting adjustment and autofocus - The C920x automatically fine-tunes to the lighting conditions to produce bright, razor-sharp images even if you’re in a low-light setting.\n" +
                "XSplit VCam – Remove, replace and blur your background without a Green Screen.\n" +
                "3-month XSplit VCam license. Mic range-Up to 3 feet (1 m)\n" +
                "1 year limited hardware warranty"),
        Product("SVS Prime Tower Speakers","$1,198.00","Gray",R.drawable.speaker,"2 - Prime Tower Speaker (Premium Black Ash)\n" +
                "Dual 6.5-inch woofers deliver effortlessly deep and articulate bass to set the mood and punctuate the low-end impact of instruments basslines and movie sound effects.\n" +
                "1-inch aluminum dome tweeter is light efficient and rigid and plays crystal clear at high volume\n" +
                "Innovative SoundMatch Crossover Design\n" +
                "4.5\" Midrange driver"),
        Product("LG Electronics OLED65E6P Flat 65-Inch 4K Ultra HD Smart OLED TV (2016 Model)","$2,6900","Black",R.drawable.camera,"New 30.4 Megapixel full-frame CMOS sensor for versatile shooting in nearly any light, with ISO range 100-32000; expandable up to 50-102400 (equivalent ISO).\n" +
                "\n" +
                "Dimensions (W x H x D): TV without stand: 57.5\" x 35.2\" x 2.2\", TV with stand: 57.5\" x 35.2\" x 7.9\"\n" +
                "Superb Dual Pixel CMOS AF for responsive and smooth AF during video or live view shooting; LCD monitor has a full touchscreen interface, including selection of AF area.\n" +
                "Excellent performance - up to 7.0 fps continuous shooting speed with high-performance DIGIC 6 plus Image Processor for improved speed and excellent image quality.\n" +
                "Use the EOS Utility Webcam Beta Software (Mac and Windows) to turn your Canon camera into a high-quality webcam, or do the same using a clean HDMI output.\n")

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE,R.style.ThemeOverlay_AppCompat_Light);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.category_detail,container,false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.layoutManager=LinearLayoutManager(context);
        var adapter=ProductAdapter(products as ArrayList<Product>, activity as AppCompatActivity);
        recyclerView.adapter=adapter;
        toolbar.setNavigationOnClickListener { dismiss() }
    }
}