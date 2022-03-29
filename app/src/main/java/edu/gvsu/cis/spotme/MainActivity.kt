package edu.gvsu.cis.spotme

import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable
import edu.gvsu.cis.spotme.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        //This checks the connection to Google Play Services, a result code of 0 means success
        var resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this)
        println(resultCode);

//        when {
//            ContextCompat.checkSelfPermission(
//                this, Manifest.permission.BLUETOOTH) == Packagemanager.PERMISSION_GRANTED ->{
//                    //use api that requres permission
//                }
//            shouldShowRequestPermissionRationale(...) -> {
//                //
//                showInContextUI(..)
//            }
//            else -> {
//                //directly ask for permission
//                requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH)
//            }
//        }

    }

    //Requesting Permissions
//    private fun requestPermissionLauncher() {
//        if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.BLUETOOTH)){
//            //provide additional rationale
//            layout.showSnackbar(R.string.app_name, Snackbar.LENGTH_SHORT, R.string.app_name){
//                requestPermissionsCompat(arrayOf(Manifest.permission.BLUETOOTH), )
//            }
//        }
//    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

